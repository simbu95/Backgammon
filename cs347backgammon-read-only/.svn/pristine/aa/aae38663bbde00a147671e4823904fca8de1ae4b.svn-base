
if [ $1"" == "" ]
then
    server='localhost'
    echo 'No server specified, defaulting to localhost'
else
    server=$1;
fi

java -Djna.library.path=./ -jar alpha1.jar $server $2
