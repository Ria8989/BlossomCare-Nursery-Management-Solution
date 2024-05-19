# Use a lightweight web server as the base image
FROM nginx:alpine

# Copy the frontend files to the default Nginx public directory
COPY . /usr/share/nginx/html

#COPY nginx.conf /etc/nginx/conf.d/default.conf

# Expose port 80 for the web server
EXPOSE 80

# Command to start the Nginx web server
CMD ["nginx", "-g", "daemon off;"]
