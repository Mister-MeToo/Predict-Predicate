# PredicateWebApplication

PredicateWebApplication is a small NetBeans/Ant-based Java web application skeleton (package: za.ac.tut) that provides a web front-end and server-side code intended to host a predicate-prediction feature or similar web service. The repository contains Java domain entities and web-layer classes and is designed to be built with Ant or run from NetBeans.

> NOTE: This README describes the project structure, runtime requirements, and gives example request/response pairs as a starting point. The repository currently contains the Java source layout (src/java/za/ac/tut) and web resources (web/). Update the example endpoints below to match the actual servlets/controllers implemented under `src/java/za/ac/tut/web`.

## Purpose

Provide a small web application that can expose a predicate-prediction service via HTTP (web UI and/or API). The current codebase appears to be an application skeleton created by NetBeans (project name: `PredicateWebApplication`) with domain entities (e.g., `za.ac.tut.entities.User`) and web-layer sources under `za.ac.tut.web`.

## Stack / Requirements

- Java: JDK 8 or later (build and run using a JDK compatible with your NetBeans project settings). If you use newer Java language features, pick a matching JDK and update the project properties.
- Build system: Apache Ant (project contains `build.xml` and `nbproject/` NetBeans metadata)
- Servlet container: Any Java servlet container that supports the Servlet API (e.g., Apache Tomcat 8+, Jetty 9+, or a Java EE / Jakarta EE application server)
- External libraries: None are committed to this repository. If your code depends on third-party libraries (JSON parsers, ML libraries, etc.), add the JARs to `web/WEB-INF/lib` or manage them in your IDE. NetBeans Ant projects commonly expect the container or IDE to provide servlet API classes.

## How to build and run

1. From IDE (NetBeans)
   - Open the folder as a NetBeans project (it should detect the NetBeans project via `nbproject/`).
   - Use the IDE Run/Build actions to build, run, and deploy to a configured server.

2. From the command line (Ant)

```bash
# Clean build artifacts
ant clean

# Compile and build
ant

# Run (NetBeans-generated target; may open and deploy to the IDE-configured server)
ant run
```

After a successful build, check the `dist/` directory for a generated WAR (if the project is configured to produce one) and deploy it to your servlet container by copying the WAR into the container's `webapps/` directory (Tomcat) or following your server's deployment process.

## Configuration

- Project properties are stored in `nbproject/`. Use NetBeans Project Properties to set Java source level, classpath libraries, and server runtime.
- If your app requires environment-specific configuration (API keys, external services), add them to a properties file and avoid committing secrets to the repo.

## Example API (placeholder)

The repository does not include a documented public API. Below are example request/response payloads you can adapt when implementing your prediction endpoints. Replace `/predict` with the actual servlet mapping or endpoint path from `src/java/za/ac/tut/web`.

Example JSON request (POST /predict)

```json
{
  "input": "subject: John; object: book; context: wants to read",
  "top_k": 3
}
```

Example JSON response

```json
{
  "predictions": [
    {"predicate": "reads", "score": 0.92},
    {"predicate": "borrows", "score": 0.48},
    {"predicate": "owns", "score": 0.12}
  ]
}
```

Example form POST (HTML)

```html
<form method="post" action="/PredicateWebApplication/predict">
  <label>Input</label>
  <textarea name="input">subject: John; object: book</textarea>
  <button type="submit">Predict</button>
</form>
```

These samples are illustrative. Inspect your servlet mappings (e.g., `web/WEB-INF/web.xml` or servlet annotations in `src/java/za/ac/tut/web`) to determine the actual paths and request formats.

## Notes for maintainers

- If you add third-party libraries, prefer recording them in a short section here (or migrate to Maven/Gradle for dependency management).
- Add a `WEB-INF/lib` listing or commit commonly used libraries if you intend the repository to be buildable outside the original IDE configuration.
- Add real API documentation (endpoints, parameters, sample responses) once the web layer endpoints are confirmed.

## Where to look in the code

- Java sources: `src/java/za/ac/tut` (domain entities under `entities`, web layer under `web`)
- Web resources: `web/` (static assets, JSPs, and possibly `WEB-INF`)
- Build: `build.xml` and `nbproject/` (NetBeans configuration)

