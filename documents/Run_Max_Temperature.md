1. Copy Data to Docker
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
    
    
Run Hadoop from TestScalding
    . run-local.sh