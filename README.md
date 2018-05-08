0. Gegneral introduction for Hadoop
    
    * Introduction: https://hortonworks.com/tutorial/learning-the-ropes-of-the-hortonworks-sandbox/
        - Docker: IP Address = 127.0.0.1
        - After installation, read this page first
        
    * Introduction +: https://hortonworks.com/tutorial/hadoop-tutorial-getting-started-with-hdp/section/1/
        - Important Concepts
        
1. Copy Data to Docker

    '''
    docker cp ~/cookie.txt sandbox-hdp:/root/chen/
    '''
    
2. Put Data to Hadoop
    
    '''
    hadoop fs -mkdir /user/input
    hadoop fs -put /root/weather/ /user/input/ 
    hadoop fs -ls /user/input/weather
    '''
    
3. Put Jar file to Docker
    
    '''
    docker cp ./target/scala-2.11/testbigdata_2.11-1.0.jar sandbox-hdp:/root/
    
    hadoop jar testbigdata_2.11-1.0.jar FileSystemCat /user/data/note.txt
    '''
    
4. Run Jar file
    
    '''
    hadoop jar testbigdata_2.11-1.0.jar MaxTemperature /user/input/weather/1901.gz output
    '''
    
5. output is folder in Hadoop

    '''
    hadoop fs -get output /root/
    cd output
    cat part-r-00000
    '''
    
6. Run Hadoop
 
    Step 0 => if docker image does not exist
    
              Down: https://hortonworks.com/downloads/#sandbox
                  * Select HDP -> Import on Docker -> Download
              
              0.0 Import to Docker: https://hortonworks.com/tutorial/sandbox-deployment-and-install-guide/section/3/
                  * Set Docker with 4 Cores and 8G Memory
                  * See more details on the page
                  * docker load -i <sandbox-docker-image-path>
                  * Check docker images
                  
              0.1 Download from Docker Hub
                  * https://hub.docker.com/r/hortonworks/sandbox-hdp-standalone/
                  * docker pull hortonworks/sandbox-hdp-standalone 
                  
    Step 1 => execute shell
              
              '. start-sandbox-hdp-standalone_2-6-4.sh'
              
              Above shell script contains 'docker pull ...'
              
    Step 2 => Add Sandbox Hostname to your host file  
    
              '''
              echo '127.0.0.1 sandbox.hortonworks.com sandbox-hdp.hortonworks.com sandbox-hdf.hortonworks.com' | sudo tee -a /private/etc/hosts
              ''
    
              To be able to access HDP services on the Sandbox from our host machine’s browser, 
              you will need to add sandbox.hortonworks.com mapped to your IP address to the list of hosts in your hosts file. 
              The location of the hosts file is different for each OS. Mac => "~/.ssh/known_hosts".
                  
                  For mac users, enter the following command in your terminal:
                  
                  '''
                  echo '{Host-Name} sandbox.hortonworks.com' | sudo tee -a /private/etc/hosts
                  '''
                  
                  NOTE: In single machine, just replace {Host-Name} with 127.0.0.1
                  
                  '''
                  echo '127.0.0.1 sandbox.hortonworks.com' | sudo tee -a /private/etc/hosts
                  '''
                  
    Step 3 => Connect to the welcome screen
              * Append the port number :8888 to your host address, open your browser, and access Sandbox Welcome page at http://_host_:8888/.
                    
                  In single machine, just replace _host_ with 127.0.0.1 (http://127.0.0.1:8888/#)
                  
                  Username: raj_ops, maria_dev, holger_gov, amy_ds
                  Password:
                 
                  (3.1) SSH Client
                  
                      Use the SSH client of your choice:
                      
                      ssh root@127.0.0.1 -p 2222
                      
                      username/password: root / hadoop  (p@ssw0rd)
                 
                      
                      If no SSH client is installed, use the built-in web client:
                      
                      http://127.0.0.1:4200
                      
                      Copy file from docker: docker cp sandbox-hdp:/root/build.out ~/workspace/
                      Copy file to docker:   docker cp ~/cookie.txt sandbox-hdp:/root/chen/
                      
                      
                     ====
                      
                      Copy file from Host to Hadoop Server:
                          https://www.tutorialspoint.com/hadoop/hadoop_hdfs_operations.htm
                          
                          * hadoop fs -mkdir /user/input 
                          * hadoop fs -put /home/file.txt /user/input 
                          * hadoop fs -ls /user/input 
                          
                          * hadoop fs -cat /user/output/outfile 
                          * hadoop fs -get /user/output/ /home/hadoop_tp/ 
                      
                      
                  (3.2) Zeppelin
                      http://127.0.0.1:9995
                      
                      
                  (3.3) Ranger
                      http://127.0.0.1:6080     
                  
                      username & password: raj_ops
                              
                              
                  (3.4) WORKFLOW MANAGER
                      http://127.0.0.1:8080/#/main/views/WORKFLOW_MANAGER/1.0.0/workflow_manager
                      
                      username & password: raj_ops
                                      
                                      
                  (3.5) Ambari
                      http://127.0.0.1:8080
                      
                      Cluster Operator
                      username & password: raj_ops
                      
                      Ambari Admin 
                      Get instructions to set password
                      
                      Note: Ambari supports multiple roles
              
              
                  (3.6) Check HDFS Data
                      https://hortonworks.com/tutorial/hadoop-tutorial-getting-started-with-hdp/section/2/
                      
                  
                  (3.7) Install RStudio on Hortonworks Docker Sandbox
                      https://community.hortonworks.com/content/kbentry/69424/setting-up-rstudio-on-hortonworks-docker-sandbox-2.html
