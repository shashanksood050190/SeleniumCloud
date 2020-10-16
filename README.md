# SeleniumCloud
Running Selenium Test on Google Cloud Platform using @Docker , @Kubernetes, Zalenium GRID &amp; TestNG

1. Create a kubernetes cluster from compute -> kubernetes engine.

[![Screenshot-2020-10-15-204852.png](https://i.postimg.cc/R0k2JqPX/Screenshot-2020-10-15-204852.png)](https://postimg.cc/CZ4cWMpq)

2. Then open cloud shell terminal and run following commands  to setup Kubernetes cluster:

kubectl create namespace zalenium <br>
kubectl get namespace

helm repo add zalenium-github https://raw.githubusercontent.com/zalando/zalenium/master/charts/zalenium <br>
helm search repo zalenium <br>
helm install my-release --namespace zalenium zalenium-github/zalenium --set hub.serviceType="LoadBalancer" --set hub.basicAuth.enabled="true" --set hub.basicAuth.username="shashankautomation" --set hub.basicAuth.password="Zalenium2020" <br>

kubectl get service my-release-zalenium --namespace="zalenium" <br>

[![Screenshot-2020-10-15-205243.png](https://i.postimg.cc/4dv2KPHx/Screenshot-2020-10-15-205243.png)](https://postimg.cc/sQX4qpJk)

3. Execute cases from local machine using testng_zalenium file.

4. Zalenium dashboard: To see status of test case execution
[![Screenshot-2020-10-15-205408.png](https://i.postimg.cc/gcDBmMPM/Screenshot-2020-10-15-205408.png)](https://postimg.cc/V5JFFWvM)

5. Zalenium live view : To see live running test cases
[![Screenshot-2020-10-15-205504.png](https://i.postimg.cc/4NywZsPd/Screenshot-2020-10-15-205504.png)](https://postimg.cc/ykq0yqw4)

6. Grid console 
[![Screenshot-2020-10-15-205606.png](https://i.postimg.cc/V65Wqc6v/Screenshot-2020-10-15-205606.png)](https://postimg.cc/JDVX8vjC)
