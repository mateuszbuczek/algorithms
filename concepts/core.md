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
