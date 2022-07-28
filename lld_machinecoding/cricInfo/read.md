System

List<CricketTeam>
List<Matches>


stream(cricketMatch) 

CricketMatch
{
Team team1
Team tam2
Innings ( 2,4)
List<MatchStatus>
StartTime
EndTime
Toss
Stadum
Umpire
Refree
List<Commentrator>
}

MatchStatus


Tournament
List<Team>
List<Match>
Pointtable


Team
List<playaer> totalSqad
List<Player> playingEleven

Player
name;
PlayerStats
team_Name

Inning
List<OverStat>



OverStat
List<BallStat>

BallStat
{
id;
totalRun;
List<Run>;
shotType(1,2,3,4,6)
wicket
BallNumber;
Bowledby;
PlayedBy;
BallType
}

Run
// totalRun
runtType ( 4,siz,legbye,NoBall,OverThrow)

wicket
wicketType
playerOut
CaughtBy
runoutBy
Stumpeby



