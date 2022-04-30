import sys
import requests
import time
from datetime import datetime

def create_load(url, method, data_key, rps):
    sleep_interval = 1/int(rps)
    print("creating load destined to: {}".format(url))
    print("request rate: {}/second".format(rps))
    print("method: {}".format(method))
    print("data_key: {}".format(data_key))
    print("sleep interval: {}".format(sleep_interval))

    while 1:
        date_string=datetime.utcnow().strftime('%Y-%m-%d %H:%M:%S.%f')
        if method == "post":
            payload = {data_key : date_string}
            print(payload)
            requests.post(url, data=payload)
        # TO DO: Add other methods here
        time.sleep(sleep_interval)
  
if __name__ == "__main__":
    url = sys.argv[1]
    method = sys.argv[2]
    data_key = sys.argv[3]
    rps = sys.argv[4]

    create_load(url, method, data_key, rps)
