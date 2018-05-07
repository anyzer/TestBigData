1. Copy Data to Docker (Host)

2. Put Data to Hadoop
    hadoop fs -mkdir /user/input
    hadoop fs -put /root/weather/ /user/input/ 
    hadoop fs -ls /user/input/weather

3. Put Jar file to Docker

4. Run Jar file
    hadoop jar testbigdata_2.11-1.0.jar MaxTemperature /user/input/weather/1901.gz output

5. output is folder in Hadoop
    hadoop fs -get output /root/
    cd output
    cat part-r-00000
     
6. Run Hadoop Server from TestScalding
    . run-local.sh
    
    
A MapReduce job is a unit of work that the client wants to be performed: it consists of the input data, the MapReduce program, 
and configuration information. Hadoop runs the job by dividing it into tasks, of which there are two types: map tasks and reduce tasks. 

The tasks are scheduled using YARN and run on nodes in the cluster. If a task fails, it will be automatically rescheduled 
to run on a different node.

Hadoop divides the input to a MapReduce job into fixed-size pieces called input splits, or just splits. Hadoop creates 
one map task for each split, which runs the user-defined map function for each record in the split.
For most jobs, a good split size tends to be the size of an HDFS block, which is 128 MB by default.









