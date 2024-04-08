# Use latest image from UBUNTU installed in the machine
FROM ubuntu:latest

# Update ubuntu system
RUN apt-get update
RUN apt autoremove

# Install maven on ubuntu image
FROM maven:3.5-jdk-8-alpine

# Make directory and set working directory
RUN mkdir "curaHealthCare"
COPY . /cura
WORKDIR "/curaHealthCare"

# Print present working directory
RUN pwd

# Run a maven command
RUN mvn -version