stackoverFlow

user
guest
members
moderator
admin


//Question ( id , description , auther_id, upvote int,downVote, QuestionsStatus, linked_question_id)//list of comments&replies

//QuestionsTag( id, tag_id,questions_id)

//tag( id , name , description)

Answers( id , questionid, description,auther, upVoteCount,downVoteCount)

commentsAndReplies( id,  questionid, answerId, autherid, parent_comment_id , )

//user

StackOverFlowAPI
//List<Questons

Question{ id, List<Tag> List<CommentAndReply>,  auther_id,Questions Status, Question linkedQuestions , List<answers>}
tag( id , name)
CommentAdReply( id, desc, Comment parentComment, auther )
Answer{
//id,
Question
List<comments>
List<tags>
Auther
description;
}


SearchAPI,
{
     getQuestion( question id)
      getQuestions( List<tag>)
    getQuestions( String keyword)
}

AdminAPI
{
blockUserAccount;
ActiveateUserAccount ;
}

ModeratorAPI{
closeQuestion;
OpenQuestion;
moderateQuestions()
}


Member
{
search&ViewApi
ModifyApi

createQuestions
answerQuestion

}


Guest
{
ViewApi

}

search&ViewApi
{
searchQuestion
ViewQuestion
register
}

ModifyApi
{
Add question
Add answer
Add Comments
}

=======================================================================================


Question
title
description
viewCount;
UpVoteCount;
downVoteCount
creationTime
qstatus ( OPEN, CLOSED, ONHOLD, DELETED)
closingRemark
List<Tag>
List<Comments>
List<Photos>
List<Answers>
Bounty

//Tag
id,tag,category_type

//Comment
id,content,Auther, parentComment Comment, voteCount accepted dateTime

Anser
id,content,Auther, List<Comment>, voteCount accepted dateTime List<Photos>, Notification

Search Api
//refer Question entity

Member
collect badges
---------------------
create Tag
createQuestion
answerQuestion

Moderator
closeQuestion
undeelteQuestion

Admin
block unblock

guest
registerAccount
----
uses
search



