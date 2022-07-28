Linkedin
{}
 Account ( status, acntid, password
Person extends Account
//id, name, email , adress,

Admin Member will extend this Person

member
profile
List<Following>
DateOfJoining
List<Post>
-------------
createPost
sendMessage
createGroup
follow(Member)
followCompany)
followGroup(Group)

profile
List<Experience>
List<Education>
List<Skill>
List<Recommendation>
Stats

//Stats ( , totalView List<member> visitor)
member can follow member & group & company
Company
id;
name
List<JobPosting>
canAddJobPosting

//JobPosting
dateOfPosting
desc
employmentType...

Group
id,
date,
totalmember;
List<Members>



Member can create Post

Post
string.
totalLikes
totalViews
Notification


Message
sendTo member[]
messageBody
mdecia blob[]
--------------------


connectionInvite
dateCreated
sttus
sentTo Member

https://github.com/guy-with-curly-hair/grokking-the-object-oriented-design-interview/blob/master/object-oriented-design-case-studies/design-linkedin.md
