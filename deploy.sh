docker build -t jdiaz740/eureka-server:latest -t jdiaz740/eureka-server:$TAG -f ./eureka-server/Dockerfile ./eureka-server
docker build -t jdiaz740/config-server:latest -t jdiaz740/config-server:$TAG --build-arg ENC_PASS=${JASYPT_PASS} -f ./config-server/Dockerfile ./config-server
docker build -t jdiaz740/auth-server:latest -t jdiaz740/auth-server:$TAG -f ./auth-server/Dockerfile ./auth-server
docker build -t jdiaz740/zuul-server:latest -t jdiaz740/zuul-server:$TAG -f ./zuul-server/Dockerfile ./zuul-server
docker build -t jdiaz740/users-service:latest -t jdiaz740/users-service:$TAG -f ./users-service/Dockerfile ./users-service

docker push jdiaz740/config-server:latest
docker push jdiaz740/auth-server:latest
docker push jdiaz740/zuul-server:latest
docker push jdiaz740/users-service:latest

docker push jdiaz740/config-server:$TAG
docker push jdiaz740/auth-server:$TAG
docker push jdiaz740/zuul-server:$TAG
docker push jdiaz740/users-service:$TAG

kubectl apply -f k8s

kubectl set image deployments/auth-server-deployment auth-server=jdiaz740/auth-server:$TAG
kubectl set image deployments/config-server-deployment config-server=jdiaz740/config-server:$TAG
kubectl set image deployments/eureka-server-deployment eureka-server=jdiaz740/eureka-server:$TAG
kubectl set image deployments/zuul-server-deployment zuul-server=jdiaz740/zuul-server:$TAG
kubectl set image deployments/users-service-deployment users-service=jdiaz740/users-service:$TAG