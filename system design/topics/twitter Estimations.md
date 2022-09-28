Example: Estimate Twitter QPS and storage requirements
Please note the following numbers are for this exercise only as they are not real numbers
from Twitter.
Assumptions:
• 300 million monthly active users.
• 50% of users use Twitter daily.
• Users post 2 tweets per day on average.
• 10% of tweets contain media.
• Data is stored for 5 years.
Estimations:
Query per second (QPS) estimate:
• Daily active users (DAU) = 300 million * 50% = 150 million
• Tweets QPS = 150 million * 2 tweets / 24 hour / 3600 seconds = ~3500
• Peek QPS = 2 * QPS = ~7000
We will only estimate media storage here.
• Average tweet size:
• tweet_id 64 bytes
• text 140 bytes
• media 1 MB
• Media storage: 150 million * 2 * 10% * 1 MB = 30 TB per day
• 5-year media storage: 30 TB * 365 * 5 = ~55 PB


Important