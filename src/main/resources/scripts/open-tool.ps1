# java -cp ../lib/hsqldb.jar org.hsqldb.util.DatabaseManagerSwing
cls
cd $PSScriptRoot
cd .. 
$baseLocation = Get-Location
$hsqlJarLocation = "$baseLocation\hsql"
Write-host "===================="
Write-host "Welcome to PESCRAP"
Write-host "===================="
Write-host "Opening database..."
java -cp $hsqlJarLocation\hsqldb_6148.jar org.hsqldb.util.DatabaseManagerSwing