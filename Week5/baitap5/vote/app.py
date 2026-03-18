from flask import Flask, render_template, request, make_response, g
import redis
import os

app = Flask(__name__)

redis_host = os.getenv('REDIS_HOST', 'redis')

r = redis.Redis(host=redis_host, port=6379, db=0)

@app.route('/', methods=['GET', 'POST'])
def vote():
    if request.method == 'POST':
        vote = request.form['vote']
        r.incr(vote)
        return make_response(render_template('index.html', message='Vote recorded!'))
    return render_template('index.html')

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)