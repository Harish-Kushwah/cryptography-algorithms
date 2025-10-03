import rsa

# Generate public and private keys
(public_key, private_key) = rsa.newkeys(512)

# Accept password input
password = "XYZ"
print("Password:", password)

# Encrypt password
encrypted_password = rsa.encrypt(password.encode(), public_key)
print("Encrypted password:", encrypted_password)

# Decrypt password
decrypted_password = rsa.decrypt(encrypted_password, private_key).decode()
print("Decrypted password:", decrypted_password)
