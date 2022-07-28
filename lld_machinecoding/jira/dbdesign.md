JiraDashBoard
List<Jira>

Jira
{
id;
title;
Persson createdby;
list<Document>
list,Images>
List<SubJira>;
estimatedTime;
List<Comments>
List<history>

}
epic(id, name)
//jira( id , title , priority, epic_id,create by, categoryType, GitCommitlink
creationDateTime, originalEstimation, logging, remaining, parent_jira_id)
categoryType(feature, bugfix, enhancement)
//commentsAndReply(id, jira_id,content,owner/writer_id,parent_comment)
//documents(id,type,jira_id,filepath)
//images( id,type,jira_id, image/path/blobstorage)
//history( id, jira_id,change_made)//immutable and will be call for every action
//gitjirlink( id, jira_id,lastcommit,git_commit_url)


