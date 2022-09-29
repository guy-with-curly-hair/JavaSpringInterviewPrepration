# Multi-container Pods

<br />

### Create a multi-container pod `multi-container-pod` with 2 containers
 - first container name `nginx` with image `nginx`
 - second container name `redis` with image `redis`

<details><summary>show</summary><p>

```yaml
cat << EOF > multi-container-pod.yaml
apiVersion: v1
kind: Pod
metadata:
  name: multi-container-pod
spec:
  containers:
  - image: nginx
    name: nginx
  - image: redis
    name: redis
EOF

kubectl apply -f multi-container-pod.yaml
```

</p></details>

<br />

### Create a multi-container pod using the fluentd acting as a sidecar container. with the given specs below. Update the deployment such that it runs both containers and the log files from the first container can be shared/used by the second container. Mount a shared volume /var/log on both containers, which does not persist when the pod is deleted.

```yaml
apiVersion: v1
kind: Pod
metadata:
  name: counter
spec:
  containers:
  - name: count
    image: busybox
    args:
    - /bin/sh
    - -c
    - >
      i=0;
      while true;
      do
        echo "$i: $(date)" >> /var/log/1.log;
        echo "$(date) INFO $i" >> /var/log/2.log;
        i=$((i+1));
        sleep 1;
      done      
  - name: count-agent
    image: k8s.gcr.io/fluentd-gcp:1.30
    env:
    - name: FLUENTD_ARGS
      value: -c /etc/fluentd-config/fluentd.conf
    volumeMounts:
    - name: config-volume
      mountPath: /etc/fluentd-config
  volumes:
  - name: config-volume
    configMap:
      name: fluentd-config
```

#### Create fluentd-config as its needed for fluentd and mounted as config.

```yaml
cat << EOF > fluentd-sidecar-config.yaml
apiVersion: v1
kind: ConfigMap
metadata:
  name: fluentd-config
data:
  fluentd.conf: |
    <source>
      type tail
      format none
      path /var/log/1.log
      pos_file /var/log/1.log.pos
      tag count.format1
    </source>

    <source>
      type tail
      format none
      path /var/log/2.log
      pos_file /var/log/2.log.pos
      tag count.format2
    </source>

    <match **>
      type google_cloud
    </match>    
EOF

kubectl apply -f fluentd-sidecar-config.yaml
```

<details><summary>show</summary><p>

```yaml
cat << EOF > two-files-counter-pod-agent-sidecar.yaml
apiVersion: v1
kind: Pod
metadata:
  name: counter
spec:
  containers:
  - name: count
    image: busybox
    args:
    - /bin/sh
    - -c
    - >
      i=0;
      while true;
      do
        echo "$i: $(date)" >> /var/log/1.log;
        echo "$(date) INFO $i" >> /var/log/2.log;
        i=$((i+1));
        sleep 1;
      done      
    volumeMounts: 
    - name: varlog # mount the varlog volume as the /var/log path
      mountPath: /var/log
  - name: count-agent
    image: k8s.gcr.io/fluentd-gcp:1.30
    env:
    - name: FLUENTD_ARGS
      value: -c /etc/fluentd-config/fluentd.conf
    volumeMounts:
    - name: varlog # mount the varlog volume as the /var/log path
      mountPath: /var/log
    - name: config-volume
      mountPath: /etc/fluentd-config
  volumes:
  - name: varlog # define varlog volume as empty dir which does not persist when the pod is deleted.
    emptyDir: {}
  - name: config-volume
    configMap:
      name: fluentd-config
EOF

kubectl apply -f two-files-counter-pod-agent-sidecar.yaml
```

```bash
kubectl get pod counter
# NAME      READY   STATUS    RESTARTS   AGE
# counter   2/2     Running   0          24s

kubectl exec counter -c count -- cat /var/log/1.log
# : Sat Dec 18 02:34:35 UTC 2021
# : Sat Dec 18 02:34:35 UTC 2021

kubectl exec counter -c count-agent -- cat /var/log/1.log
# : Sat Dec 18 02:34:35 UTC 2021
# : Sat Dec 18 02:34:35 UTC 2021
```

</p></details>

<br />