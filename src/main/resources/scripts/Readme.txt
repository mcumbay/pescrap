https://www.journaldev.com/21466/hsqldb-tutorial
=====================
CREATE THE LOCAL DB
=====================

Database locally run on Hyper SQL.
To get the latest version go to http://www.hsqldb.org/download/

1. Open a terminal
2. Change directory to hsql folder
Ex: 
	cd C:\Users\Administrator\git\pescrap\src\main\resources\hsql
3. Open the Utility
Ex:
	java -cp hsqldb_6148.jar org.hsqldb.util.DatabaseManagerSwing
4. Create the database:
Ex:
	java -cp ..\hsqldb_6148.jar org.hsqldb.server.Server --database.0 file:pescrap-db-file --dbname.0 xdb
5. Start Server


jdbc:hsqldb:file:C:/Users/Administrator/git/pescrap/src/main/resources/hsql/pesdb/pesdb	