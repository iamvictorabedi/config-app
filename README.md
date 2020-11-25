# Kyosk Backend - Victor
This application is build on spring java and packages in a public docker image 
>docker pull iamvictorabedi/config-kyosk:latest
## Problem definition

The aim of test is to create a simple HTTP service that stores and returns configurations that satisfy certain conditions.
Since we love automating things, the service should be automatically deployed to kubernetes.

### Endpoints
Following are the endpoints are implemented:

| Name   | Method      | URL
| ---    | ---         | ---
| List   | `GET`       | `/configs`
| Create | `POST`      | `/configs`
| Get    | `GET`       | `/configs/{name}`
| Update | `PUT/PATCH` | `/configs/{name}`
| Delete | `DELETE`    | `/configs/{name}`
| Query  | `GET`       | `/search?metadata.key=value`

#### Query

The query endpoint **MUST** return all configs that satisfy the query argument.

Query example-1:

```sh
curl http://config-service/name=datacenter-1
```

Response example:

```json
[
  {
    "name": "datacenter-1",
    "metadata": {
      "monitoring": {
        "enabled": "true"
      },
      "limits": {
        "cpu": {
          "enabled": "false",
          "value": "300m"
        }
      }
    }
  }
]
```

#### Schema

- **Config**
  - Name (string)
  - Metadata (nested key:value pairs where both key and value are strings of arbitrary length)

### To Run on Minikube
1. Pull a Docker image and create a minikube deployment (docker pull iamvictorabedi/config-kyosk:latest)

2. Expose the deployment that will create a service inside the minikube cluster
3. Run 
>kubectl run config-victor --image/iamvictorabedi/config-kyosk:latest --port=8080

4. To access the service run::
>minikube service config-victor --url
