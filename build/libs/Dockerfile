FROM openjdk
# specify what the environment in my container should be

COPY . /workspace
# copy all files in the current folder and put them in a folder called workspace in the virtual environment when created

WORKDIR /workspace
# any commands we run in our dockerfile will execute from that location

EXPOSE 8080
# we specify what port our application runs on

ENV APPSETTING_azure_p1_sql_jdbc="jdbc:postgresql://farrens-postgres-sql-server.postgres.database.azure.com:5432/p1_council_db?user=Ershada&password=Work4IT!&ssl=false/postgres?currentSchema=public"

ENTRYPOINT java -jar P1-Swallow-Falls2-1.0-SNAPSHOT.jar
# what command will be used to start my application