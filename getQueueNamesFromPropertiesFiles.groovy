    def getQueueNamesFromPropertiesFiles(String propertyfilename) {
        def outputvar = ""

        File fh1 = new File(propertyfilename);
        File fh2 = new File(propertyfilename);
        def lines = fh2.readLines();

            for (line in lines) {
                if(line.contains("messaging.queue.")&&line.contains(".name"))
                {
                    outputvar= outputvar+line+"\n";
                }
            }
        return outputvar;
    }
    def applicationpropertiesfile = 'application.properties';

    println(getQueueNamesFromPropertiesFiles(applicationpropertiesfile));