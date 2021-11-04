def updateQueueCredentialsinPropertiesFile(String queuecredentials, String propertyfilename)
    {
        String[] queuecredential = queuecredentials.split('\n');
        def tmpfilename = propertyfilename+'.tmp';
        def tmpFile = new File(tmpfilename);
        tmpFile.createNewFile();
        new FileWriter(tmpfilename, true).with {
        new File(propertyfilename).eachLine { line ->
            for(String queuecredentialkeyvalue : queuecredential)
                {
                    String[] queuecredentialkeyvaluesplit = queuecredentialkeyvalue.split('=')
                    if(line.contains(queuecredentialkeyvaluesplit[0])) {
                            line = queuecredentialkeyvalue;
                    }    
                }
                write(line +"\n");
            }
                flush();
        }
        def propertyfilenamebackup = propertyfilename+'.bak';
        def existingFile = new File(propertyfilename);
        existingFile.renameTo(propertyfilenamebackup);
        tmpFile.renameTo(propertyfilename);
    }

    def queuecredentials = 'messaging.queue.process1.username=ENC(queue1username)\nmessaging.queue.process2.username=ENC(queue2username)\nmessaging.queue.process3.username=ENC(queue3username)\nmessaging.queue.process4.username=ENC(queue4username)\nmessaging.queue.process5.username=ENC(queue5username)\nmessaging.queue.process1.password=ENC(queue1password)\nmessaging.queue.process2.password=ENC(queue2password)\nmessaging.queue.process3.password=ENC(queue3password)\nmessaging.queue.process4.password=ENC(queue4password)\nmessaging.queue.process5.password=ENC(queue5password)'
    def applicationcredentialspropertiesfile = 'application-credentials.properties';
    updateQueueCredentialsinPropertiesFile(queuecredentials, applicationcredentialspropertiesfile);