variable "gcp_credentials" {
  type = string
  description = "Location for service account for GCP"
}

variable "gcp_project_id" {
  type = string
  description = "GCP project id"
}

variable "gcp_region" {
  type = string
  description = "GCP Region"
}

variable "gcp_cluster_name" {
  type = string
  description = "GCP cluster name"
}


variable "gke_zones" {
  type = list(string)
  description = "List of zones of GKE cluster"
}

variable "gke_regional" {
  type = bool
  description = "Specifying the region"
}


variable "gke_network" {
  type = string
  description = "VPC Network name"
}

variable "gke_subnetwork" {
  type = string
  description = "VPC Sub Network name"
}

variable "gke_nodepool_name" {
  type = string
  description = "GKE Default node pool name"
}


variable "gke_service_account" {
  type = string
  description = "GKE service account name"
}

