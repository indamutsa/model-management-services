/**
 * If you're inside the Kubernetes cluster and you've used port-forwarding to map the service port 8082 to your local machine's port 8082, your frontend should be able
 * to connect to `http://localhost:8082/` directly. However, the context in which the frontend code runs matters.
 *
 * ### Scenarios:
 *
 * 1. **Frontend running locally:** You don't need to change anything, the frontend will be able to access the backend at `http://localhost:8082/`.
 * 2. **Frontend running in a Pod in the same cluster:** The frontend needs to reach the backend via the service name, i.e., `http://dsl-backend-server:8082/`.
 * 3. **Frontend running somewhere else:** You'd need to expose your backend service publicly via an Ingress Controller or a LoadBalancer service type.
 *
 * Here's how you could configure your `module.exports` in each case:
 */

// // 1. Frontend running locally:

// module.exports = {
//   baseUrl: "localhost:8082/",
//   protocol: "http://",
// };

// 2. Frontend running in the same cluster:
// module.exports = {
//   baseUrl: "dsl-backend-server:8082/",
//   protocol: "http://",
// };

// 3. Frontend running somewhere else:

module.exports = {
  baseUrl: "back.arsene.com/",
  protocol: "http://",
};

// FILE: <project>/frontend/src/services/ConnectionData.js

// module.exports = {
//   baseUrl: "localhost:8082/", //"178.238.238.209:8082/", //`back.34.107.29.78.sslip.io/`, //"35.234.74.94:30100/",
//   protocol: "http://",
// };
