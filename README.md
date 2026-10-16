# PredicateWebApplication

PredicateWebApplication is a small NetBeans Java web application skeleton (package: za.ac.tut) that provides a web front-end and server-side code intended to host a predicate-prediction feature.

## Purpose

Provide a small web application that can expose a predicate-prediction service via HTTP (web UI and/or API).

## How to build and run

1. From IDE (NetBeans)
   - Open the folder as a NetBeans project
   - Use the IDE Run/Build actions to build, run, and deploy to a configured server.

After a successful build, check the `dist/` directory for a generated WAR (if the project is configured to produce one) and deploy it to your servlet container by copying the WAR into the container's `webapps/` directory (Tomcat) or following your server's deployment process.

