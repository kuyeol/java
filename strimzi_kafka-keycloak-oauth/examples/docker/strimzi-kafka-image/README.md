Strimzi Kafka Image with SNAPSHOT Strimzi Kafka OAuth
=====================================================

This is a build of a Docker image based on `quay.io/strimzi/kafka:0.39.0-kafka-3.6.1` with added most recently locally built SNAPSHOT version of Strimzi Kafka OAuth libraries.

This image adds a `/opt/kafka/libs/oauth` directory, and copies the latest jars for OAuth support in it.
Then it puts this directory as the first directory on the classpath.

The result is that the most recent Strimzi Kafka OAuth jars and their dependencies are used, because they appear on the classpath before the ones that are part of `quay.io/strimzi/kafka:0.39.0-kafka-3.6.1` which are located in the `/opt/kafka/libs` directory.


Building
--------

Run `mvn install` then, use `docker build` to build the image:

    docker build -t strimzi/kafka:latest-kafka-3.6.1-oauth .

You can choose a different tag if you want.

Also, take a look at Dockerfile:

    less Dockerfile
    
Note the `FROM` directive in the first line. It uses image coordinates to a recent publicly available Strimzi Kafka 3.6.1 image.

You may want to adjust this to a different public image, or to one manually built previously and is only available in your private Docker Registry.

For example, if you want to base your image on Strimzi Kafka 3.5.2 use `FROM quay.io/strimzi/kafka:0.39.0-kafka-3.5.2`.


Validating
----------

You can start an interactive shell container and confirm that the jars are there.

    docker run --rm -ti strimzi/kafka:latest-kafka-3.6.1-oauth /bin/sh
    ls -la libs/oauth/
    echo "$CLASSPATH"
    
If you want to play around more within the container you may need to make yourself `root`.

You achieve that by running the docker session as `root` user:

    docker run --rm -ti --user root strimzi/kafka:latest-kafka-3.6.1-oauth /bin/sh



Pushing the image to a Docker Repository
--------------------------------------

For Kubernetes to be able to use our image it needs to be pushed to either a public repository or to the private Docker Repository used by your Kubernetes distro.

For example if you are using Kubernetes Kind as described in [HACKING.md](../../../HACKING.md) then your Docker Repository is listening on port 5000 of your local ethernet IP.

    # On MacOS
    export REGISTRY_IP=$(ifconfig en0 | grep 'inet ' | awk '{print $2}') && echo $REGISTRY_IP 

    # On Linux
    #export REGISTRY_IP=$(ifconfig docker0 | grep 'inet ' | awk '{print $2}') && echo $REGISTRY_IP 

    export DOCKER_REG=$REGISTRY_IP:5000
    
You need to retag the built image before so you can push it to Docker Registry:

    docker tag strimzi/kafka:latest-kafka-3.6.1-oauth $DOCKER_REG/strimzi/kafka:latest-kafka-3.6.1-oauth
    docker push $DOCKER_REG/strimzi/kafka:latest-kafka-3.6.1-oauth

Actually, Kubernetes Kind supports an even simpler option how to make an image available to Kubernetes:

    kind load docker-image strimzi/kafka:latest-kafka-3.6.1-oauth 
    
If you're using minikube, you'll need to run `minikube docker-env` before building the image.

Deploying
---------

## Via the Strimzi Repository

In order for the operator to use your Kafka image, you have to replace the Kafka image coordinates in `packaging/install/cluster-operator/060-Deployment-strimzi-cluster-operator.yaml` in your `strimzi-kafka-operator` project.

This image builds the kafka-3.6.1 replacement image, so we need to replace all occurrences where kafka-3.6.1 is referred to into the proper coordinates to our image:

    sed -Ei "s#quay.io/strimzi/kafka:latest-kafka-3.6.1#${DOCKER_REG}/strimzi/kafka:latest-kafka-3.6.1-oauth#" \
        packaging/install/cluster-operator/060-Deployment-strimzi-cluster-operator.yaml


It's best to check the `060-Deployment-strimzi-cluster-operator.yaml` file manually to make sure everything is in order:

    less packaging/install/cluster-operator/060-Deployment-strimzi-cluster-operator.yaml


You can now deploy Strimzi Kafka Operator following instructions in [HACKING.md](../../../HACKING.md)

## Via Helm

You can also run the operator via its Helm chart and set the `kafka.image.registry` property to your local registry. As an example, if you've built and tagged the image as `local.dev/strimzi/kafka:0.39.0-kafka-3.6.1`. You can run it using the operator as:

    helm repo add strimzi https://strimzi.io/charts/ --force-update
    helm upgrade -i -n strimzi strimzi strimzi/strimzi-kafka-operator \
      --version 0.39.0 \
      --set watchNamespaces="{default}" \
      --set generateNetworkPolicy=false \
      --set kafka.image.registry="local.dev" \
      --wait \
      --create-namespace