import csv

def read_csv(file_path):
    data_list = []
    with open(file_path, 'r') as csv_file:
        csv_reader = csv.reader(csv_file)
        header = next(csv_reader)  # Read the header row

        for row in csv_reader:
            data_list.append(row)

    return data_list

