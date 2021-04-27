data "google_client_config" "default" {}

provider "google" {
  credentials = file(var.gcp_credentials)
  project = var.gcp_project_id
  region = var.gcp_region
}

provider "kubernetes" {
  load_config_file       = false
  host                   = "https://${module.gke.endpoint}"
  token                  = data.google_client_config.default.access_token
  cluster_ca_certificate = base64decode(module.gke.ca_certificate)
}
