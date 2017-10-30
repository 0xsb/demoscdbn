#base tools
FROM centos7:7.3.1611
MAINTAINER "liangxuezhi""liangxuezhi@cmhi.chinamobile.com""18867103600"
#install
#RUN yum clean all
#RUN yum install java-1.8.0-openjdk.x86_64 -y
RUN echo root:liangxz1 | chpasswd
RUN yum install ftp -y
RUN yum install wget -y

RUN wget --ftp-user=cmuser --ftp-password=Cmcc@1234 ftp://172.23.12.233/opp/cdnms/jdk-8u144-linux-x64.tar.gz
RUN tar -xzvf jdk-8u144-linux-x64.tar.gz

#ENV LANG C.UTF-8
ENV JAVA_HOME=/jdk1.8.0_144
ENV JRE_HOME=${JAVA_HOME}/jre
ENV CLASSPATH=.:${JAVA_HOME}/lib/dt.jar:${JAVA_HOME}/lib/tools.jar
ENV PATH=${JAVA_HOME}/bin:${PATH}

RUN wget --ftp-user=cmuser --ftp-password=Cmcc@1234 ftp://172.23.12.233/opp/cdnms/apache-tomcat-7.0.78.tar.gz
RUN tar -xzvf apache-tomcat-7.0.78.tar.gz

RUN wget --ftp-user=cmuser --ftp-password=Cmcc@1234 ftp://172.23.12.233/opp/cdnms/catalina.sh
RUN mv catalina.sh /apache-tomcat-7.0.78/bin
RUN chmod +x /apache-tomcat-7.0.78/bin/catalina.sh

WORKDIR /apache-tomcat-7.0.78/lib/
RUN wget --ftp-user=cmuser --ftp-password=Cmcc@1234 ftp://172.23.12.233/opp/cdnms/jacocoagent.jar
RUN wget --ftp-user=cmuser --ftp-password=Cmcc@1234 ftp://172.23.12.233/opp/cdnms/jacocoant.jar 

RUN wget --ftp-user=cmuser --ftp-password=Cmcc@1234 ftp://172.23.12.233/opp/cdnms/org.jacoco.agent-0.7.7.201606060606.jar
RUN wget --ftp-user=cmuser --ftp-password=Cmcc@1234 ftp://172.23.12.233/opp/cdnms/org.jacoco.ant-0.7.7.201606060606.jar
RUN wget --ftp-user=cmuser --ftp-password=Cmcc@1234 ftp://172.23.12.233/opp/cdnms/org.jacoco.core-0.7.7.201606060606.jar
RUN wget --ftp-user=cmuser --ftp-password=Cmcc@1234 ftp://172.23.12.233/opp/cdnms/org.jacoco.report-0.7.7.201606060606.jar

RUN wget --ftp-user=cmuser --ftp-password=Cmcc@1234 ftp://172.23.12.233/opp/cdnms/context.xml
RUN wget --ftp-user=cmuser --ftp-password=Cmcc@1234 ftp://172.23.12.233/opp/cdnms/commons-pool2-2.2.jar
RUN wget --ftp-user=cmuser --ftp-password=Cmcc@1234 ftp://172.23.12.233/opp/cdnms/jedis-2.4.2.jar
RUN wget --ftp-user=cmuser --ftp-password=Cmcc@1234 ftp://172.23.12.233/opp/cdnms/tomcat-redis-session-manage-tomcat7.jar
RUN wget --ftp-user=cmuser --ftp-password=Cmcc@1234 ftp://172.23.12.233/opp/cdnms/ROOT.war

RUN mv context.xml /apache-tomcat-7.0.78/conf
RUN mv ROOT.war /apache-tomcat-7.0.78/webapps
RUN rm -rfd /apache-tomcat-7.0.78/webapps/ROOT

EXPOSE 8080
EXPOSE 8494

CMD ["/apache-tomcat-7.0.78/bin/catalina.sh","run"]

