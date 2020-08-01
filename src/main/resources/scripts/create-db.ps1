
#java -cp $hsqlJarLocation\hsqldb_6148.jar org.hsqldb.server.Server --database.0 file:pesdb --dbname.0 xdb
cls
cd $PSScriptRoot
cd ..
cd hsql
$curentLocation = Get-Location
mkdir pesdb
cd pesdb
Write-host "===================="
Write-host "Welcome to PESCRAP"
Write-host "===================="
Write-host "Creating database..."
#Write-Host "$hsqlJarLocation"
java -cp $curentLocation\hsqldb_6148.jar org.hsqldb.server.Server --database.0 file:pesdb --dbname.0 xdb