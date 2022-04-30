FROM python:3

ADD load_test.py .

RUN pip install requests

CMD ["python", "load_test.py", "http://localhost", "post", "message", "1"]