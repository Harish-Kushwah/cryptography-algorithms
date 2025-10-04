def max_min_composition(R1, R2):
    result = []
    for i in range(len(R1)):
        row = []
        for j in range(len(R2[0])):
            val = max([min(R1[i][k], R2[k][j]) for k in range(len(R2))])
            row.append(val)
        result.append(row)
    return result

def max_product_composition(R1, R2):
    result = []
    for i in range(len(R1)):
        row = []
        for j in range(len(R2[0])):
            val = max([R1[i][k] * R2[k][j] for k in range(len(R2))])
            row.append(val)
        result.append(row)
    return result


# Example
R1 = [[0.2, 0.8], [0.5, 0.7]]
R2 = [[0.6, 0.3], [0.4, 0.9]]

print("Max-Min Composition:", max_min_composition(R1, R2))
print("Max-Product Composition:", max_product_composition(R1, R2))
