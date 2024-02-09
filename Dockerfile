FROM ubuntu

USER 0

RUN apt-get update && apt install wget -y && apt install git -y && apt install sudo -y

RUN wget https://download.java.net/java/GA/jdk21.0.2/f2283984656d49d69e91c558476027ac/13/GPL/openjdk-21.0.2_linux-x64_bin.tar.gz
RUN wget https://dlcdn.apache.org/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.tar.gz

RUN tar -xvf openjdk-21.0.2_linux-x64_bin.tar.gz
RUN tar -xvf apache-maven-3.9.6-bin.tar.gz

RUN mkdir -p /usr/root/jdk-21.0.2
RUN mv /jdk-21.0.2/* /usr/root/jdk-21.0.2

RUN mkdir -p /usr/root/apache-maven-3.9.6
RUN mv /apache-maven-3.9.6/* /usr/root/apache-maven-3.9.6

RUN echo PATH=/usr$HOME/jdk-21.0.2/bin:/usr$HOME/apache-maven-3.9.6/bin:$PATH >> ~/.bashrc