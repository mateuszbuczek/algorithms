## System design

### CAP theorem
- consistency - irrespective of the node we pick, data we will get for a query will always be the same
- availability - every request that comes to the datastore should get an immediate response (not timeout)
- partition tolerance - distributed load, every request must be served, even though there is a communication break between nodes
- only 2 of 3 properties can be met

- AP - distributed, eventual consistency, inter node communication, do not wait for write propagation to respond to the request
- CA - primary, slave - not distributed - if master down, redirect to slave - oracle etc. / payments security applications
- CP - distributed, wait for write propagation

### Load balancer
- virtual LB - virtualization over hardware
- hardware LB - additional hardware required, high maintenance expertise required, higher throughput
- software LB - lower cost, scale based on need
- algorithms
    - round robin - circular sequence
    - weighted round robin - assign weight to servers
    - least connection method - route to server with the least number of connections
    - least response time - route based on response time
    - hashing - hash ip address
    - sticky session

### Rate limiter
- token bucket - requests/period based on token
- leaky bucket - enqueue requests to fixed size queue, if queue is full return 409
- fixed window - requests/period 
- sliding window

### URL shortener
- redirect short url to original url
- methods of generation
    - random url (collision)
    - md5 hashing (too long)
    - counter -> base62

### Instagram

#### Functional requirements
- upload photo/create post
- view photo/post
- search users
- follow other users
- user feed display
- comment and like a post

#### Non functional requirements
- high availability
- reliable - hence partition tolerant
- eventual consistency
- low latency while user feed generation
- read heavy

#### capacity estimation
- 100m users
- 1% active users
- average size 1Mb

- storage size per day = 1M * 1MB ~ 975GB per day
- storage size in a year = 975 * 365 ~ 350TB

##### Tables
- Post table | post_id | user_id | photourl | creation_time
- User table | user_id | username | email | phone_number | creation_time
- Follower table | user_id | follower_id | following_since
- Comment table | comment_id | post_id | user_id | creation_time | comment
- Like table | like_id | parent_id | is_post | user_id | creation_time

##### upload photo
~~- store in blob column of database (not ideal for many records queries)~~
- store in s3
- implement url shortener

##### user service
- getUserDetails postUserDetails updateUserDetails
- distributed cache (searching for user)
- rdbms (fixed schema, acid)

##### follow service
- followUser getListOfUserFollowedByAUser
- rdbms (fixed schema, acid)
- put data into distributed cache

##### search user

##### post service
- uploadPost getPost getUserFeed
- communicate with s3 storage
- communicate with url shortener
- put data into database (nosql, huge data set, cassandra)
- communicate with distributed cache
- communicate with distributed queue (precompute feed generation by fan out service (puts data to distributed cache))

##### comment/like service
- addCommentToThePost getCommentToThePost addLikeToThePost getNumberOfLikesForThePost getListOfUserWhoLikedThePost
- communicate with database
- communicate distributed cache

##### promise based cache
- many cache misses will create a promise object in cache
- subsequent requests will check if a promise is present in a cache, if it is, they will wait
- this avoids bombarding of request on db

