FROM node:7
WORKDIR /app
COPY ./src/API_NodeJs/src/package.json /app
RUN npm install
COPY . /app
CMD node ./src/API_NodeJs/src/server.js
EXPOSE 4000
