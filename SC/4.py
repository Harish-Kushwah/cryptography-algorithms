def lambda_cut(A, lam):
    return [1 if a >= lam else 0 for a in A]

# Example
A = [0.2, 0.5, 0.7, 0.9]
lam = 0.6

print("Lambda Cut (λ =", lam, "):", lambda_cut(A, lam))
