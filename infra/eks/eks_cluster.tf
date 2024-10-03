resource "aws_eks_cluster" "eks_cluster" {
  name     = "fiap-tech-challenge-eks-cluster"
  role_arn = "arn:aws:iam::216714873799:role/LabRole"

  vpc_config {
    subnet_ids = ["subnet-01df860d18851014c", "subnet-01e2177a34dc69251"]
  }
}

resource "aws_eks_node_group" "eks_node_group" {
  cluster_name    = aws_eks_cluster.eks_cluster.name
  node_group_name = "my-node-group"
  node_role_arn   = "arn:aws:iam::216714873799:role/LabRole"

  subnet_ids = ["subnet-01df860d18851014c", "subnet-01e2177a34dc69251"]

  scaling_config {
    desired_size = 2
    max_size     = 3
    min_size     = 1
  }

  depends_on = [
    aws_eks_cluster.eks_cluster
  ]
}