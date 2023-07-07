# TASK-3 (Kubernetes)
- Use the application that you created in task #1 or task #2. Create dockerfiles and build docker images. Create kubernetes yaml manifests for the application (at least a deployment and a service). It’s ok to expose the application with a LoadBalancer or NodePort service or with an ingress. Spin up a single-node local Kubernetes cluster (Docker Desktop, Kind or Minikube) or use a managed cluster like EKS, AKS, GKE etc. Deploy MongoDB to the cluster (it’s ok to use a community helm chart for this, any other approach is fine as well). Then deploy the application to the cluster by applying your manifests.
The following requirements should be fulfilled:
you can bring your application up by applying your yaml manifests mongodb is running in a separate pod
the application should take mongo connection details from the environment variables
the app endpoints should be available from your host machine
a persistent volume should be used to store the MongoDB data. I.e., when you delete the MongoDB pod the records in the db should not disappear.
As part of this, I have created Dockerfiles and built Docker images for the web application that I developed earlier using the Angular framework. Additionally, I created Kubernetes YAML manifests for the application, including a deployment and a service and the application can be exposed using a LoadBalancer .

## Implementation,
- To deploy the application to a Kubernetes cluster, I spun up a single-node local Kubernetes cluster using Docker Desktop, Kind or Minikube, Previous we have checked and implemented all the rest api : https://github.com/MunwarAli12/model-java_REST-API_web_application-
- now creating docker file;  ![image](https://user-images.githubusercontent.com/126280146/233519188-a0fa1923-f125-4c68-8256-cbe19d52127a.png)
- building the Docker image; ![image](https://user-images.githubusercontent.com/126280146/233519490-3dbed23b-d155-4e06-8458-77d3e3d46610.png)

![image](https://user-images.githubusercontent.com/126280146/233519623-b3d9c879-344c-41b5-b969-b2e27e9f5f8a.png)
- image pushed to docker hub; ![image](https://user-images.githubusercontent.com/126280146/233520612-c9718240-24cc-4f71-8c62-18aee998d6d7.png)

![image](https://user-images.githubusercontent.com/126280146/233520549-bcdb7c90-b161-4cb8-b6cb-468a4065ed17.png)
- Created Kubernetes deployment file(In the root project directory, created a new file named deployment.yaml, in the Deployment manifest.
- specified the container image,environment variables fot the mongodb connection, ![image](https://user-images.githubusercontent.com/126280146/233519703-5730a057-dcb0-47c8-9998-398aa2f8e1cc.png)
- parallely kubernetes created service file(In the root project directory, created a new file named service.yaml );
- Our application is made available outside of the Kubernetes cluster using a service. It serves as the load balancer, dividing up requests made to our application among the different clustered instances of the application. ![image](https://user-images.githubusercontent.com/126280146/233519864-5db6626a-e26b-4259-8165-562188427c25.png)
- Running minikube workflow:
![image](https://user-images.githubusercontent.com/126280146/233522589-c8160283-3716-4d08-9ad2-5f392549de45.png)
![image](https://user-images.githubusercontent.com/126280146/233522675-f00a43e4-6bcb-4b8e-b604-624783e34cb4.png)
![image](https://user-images.githubusercontent.com/126280146/233522689-70144044-4789-463b-be42-da5a54498c3c.png)
- chekced pod using logs command:
![image](https://user-images.githubusercontent.com/126280146/233522768-a0cb649c-43b2-462c-a7ea-6f881e11fc54.png)
- Using the command below, we access the application endpoints from your host machine using the minikube service to make sure the application is functioning.
![image](https://user-images.githubusercontent.com/126280146/233522829-5455cd67-4908-429c-8b11-1ed9a48c6cf9.png)
- http://127.0.0.1:51418
-- workload status:
![image](https://user-images.githubusercontent.com/126280146/233522390-7b24d341-bfb8-46fd-ae2c-7e9c43b09960.png)
![image](https://user-images.githubusercontent.com/126280146/233522431-0789bf6f-4660-4a25-9a41-cc4767ecaf4b.png)
![image](https://user-images.githubusercontent.com/126280146/233522489-23450cd0-323a-4f19-b73d-14afc25642ed.png)
