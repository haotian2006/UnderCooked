import os
# ignore this
# this is to destroy are desktop.ini cause they break github
current_dir = os.getcwd()
parent_dir = os.path.dirname(current_dir)
for dirpath, dirnames, filenames in os.walk(parent_dir):
    for filename in filenames:
        if filename == "desktop.ini":
            file_path = os.path.join(dirpath, filename)
            os.remove(file_path)
            print(f"Deleted file: {file_path}")
