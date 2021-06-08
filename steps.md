## Provisioning cloud resources using Terraform
#### On the cloud dashboard


--- Create a Project on google cloud platform
--- Enable kubernetes engine, enable cloud resource manager API
--- Create a service account, and enable the basic role owner
--- Download the key pair as json, and put it in terraform

--- Login using gcloud:
>>> gcloud auth login

>> Run: terraform init --> to initialize modules
>> Run: terraform plan --> to test the resources to provision
>> Run: terraform apply --> to apply the resources
>> Run: terraform destroy --> to destroy provisioned resources

--- Once deployed, Go on the cluster and click on connect: <br>
Copy the command to connect to the cluster through the terminal


Happy deployment using Terraform on gke!

---------------------------------------------------------------------------------------

## Deployment using HELM

Before we start creating resources that related to our projects, we need to
install the nginx-ingress using the correct helm repo

I posted a stackoverflow answer on this since sometimes it fails when used the wrong repo:
https://stackoverflow.com/questions/60691946/kubernetes-ingress-path-based-routing-not-working-as-expected/67240258#67240258

Install it, please use helm version 3:

>>> helm repo add ingress-nginx https://kubernetes.github.io/ingress-nginx
>>> helm repo update
>>> helm install ingress-nginx ingress-nginx/ingress-nginx


I have compiled the above in a script called install-ingress.sh, just go to ingress and run
>>> ./install-ingress 

Once Done, wait a little to get the IP and run kubectl get all, you can watch it by adding --watch flag
Once the IP is there, copy in that in ingress-ngnix.yaml and replace it with the older IP, leave xip.io intact.

Go to terminal and run the following command to create a helm chart

The name of the folder has to be set in Chart.yaml as the name
>>> helm create name-of-folder

Install chart
>>> helm install chart-name folder-where-located chart

To upgrade the chart
>>> helm upgrade chart

To list deployment
>>> helm list

You can rollback to the previous release using <i>helm rollack num-of-the-release</i> command and see the available release by <i> helm history name-of-the-release</i>
