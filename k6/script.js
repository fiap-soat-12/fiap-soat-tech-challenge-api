import http from 'k6/http';
import { sleep } from 'k6';

var multiplyFactor = 3

export const options = {
  stages: [
    { duration: '1s', target: 5 * multiplyFactor },
    { duration: '2m', target: 5 * multiplyFactor },
    { duration: '1s', target: 10 * multiplyFactor },
    { duration: '2m', target: 10 * multiplyFactor },
    { duration: '1s', target: 15 * multiplyFactor },
    { duration: '2m', target: 15 * multiplyFactor },
    { duration: '1s', target: 20 * multiplyFactor },
    { duration: '2m', target: 20 * multiplyFactor },
    { duration: '1s', target: 25 * multiplyFactor },
    { duration: '2m', target: 25 * multiplyFactor }
  ]
};

  export default function() {
    http.get('http://aa41b21f68e1742e2a66fe97b32c42ef-1021599843.us-east-1.elb.amazonaws.com/api/v1/products?category=MAIN_COURSE&page=0&size=10');
    sleep(1);
  }
