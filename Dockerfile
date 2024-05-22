# Use the official MySQL Docker image
FROM mysql:8.0

# Environment variables for MySQL root user
ENV MYSQL_ROOT_PASSWORD=227797
ENV MYSQL_DATABASE=plant
#ENV MYSQL_USER=root
#ENV MYSQL_PASSWORD=riya@root

# Copy SQL initialization scripts (if any)
COPY ./plant.sql /docker-entrypoint-initdb.d/

# Expose MySQL default port
EXPOSE 3306

