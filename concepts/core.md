###**Write-Ahead Log**
    - persist every state change as a command to the append only log
    - class WALEntry…
        private final Long entryId;
        private final byte[] data;
        private final EntryType entryType;
        private long timeStamp;
    - at first add to wal then execute command
    - If flushing is delayed or done asynchronously, it improves performance but there is a risk of losing entries from the log if the server crashes before entries are flushed.
    - Single Log files can become difficult to manage and can quickly consume all the storage. To handle this issue, techniques like Segmented Log and Low-Water Mark are used.
    - The write ahead log is append-only. Because of this behaviour, in case of client communication failure and retries, logs can contain duplicate entries. When the log entries are applied, it needs to make sure that the duplicates are ignored. If the final state is something like a HashMap, where the updates to the same key are idempotent, no special mechanism is needed
###**Segmeneted Log**
    - A single log file can grow and become a performance bottleneck while its read at the startup. Older logs are cleaned up periodically and doing cleanup operations on a single huge file is difficult to implement
    - With log segmentation, there needs to be an easy way to map logical log offset
###**Quorum**
    - how many other servers need to confirm the replication before the original server can be confident that the update is fully recognized.
    - If the original server waits for too many replications, then it will respond slowly - reducing liveness. But if it doesn't have enough replications, then the update could be lost - a failure of safety. It's critical to balance between the overall system performance and system continuity.
    - A cluster agrees that it's received an update when a majority of the nodes in the cluster have acknowledged the update (quorum n/2 + 1.)
    - The need for a quorum indicates how many failures can be tolerated
    - High-Water Mark is used to ensure only data which is guaranteed to be available on the majority of servers is visible to clients.
   
###**Hash**
    - one directional process
    - hash function takes variable length input and returns fixed length output
    - should be complex enough to minimize the risk of collision
    - Hash table stores data in an array of buckets. Generated object hash code is an index
      that indicates the entry's value location in the array of buckets.
      During lookup, a hash for the passed key will be calculated and the corresponding value’s location will be found
      Most often |object -> hash code -> index| (for example 'any' -> 123 -> 5. at index 5 there is a key 123 with object value).

###**Compiler vs Interpreter**
    - compiler converts code but doesnt execute it, interpreter exexcutes code directly
    - compiler requires knowledge about target machine, interpreter executes the code
    - compiler each instruction is translated only once, interpreter same instruction can be analyzed multiple times

###**Concurrency**
    - multiprocessing - multiple processors executing in parallel - CPU
    - multitasking - multiple tasks running on a single cpu - Process
    - multithreading - multiple parts of the same program running - every thread has its own fixed stack - thread is managed by os
    
    go - uses small no of threads to execute variable stack space goroutines on them. Main program coordinates assigning goroutine to thread 
