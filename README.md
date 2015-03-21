# Koinonia

> Koinonia is a transliterated form of the Greek word, `κοινωνία`, which means communion, joint participation; the share which one has in anything, participation, a gift jointly contributed, a collection, a contribution

Koinonia is a decoupled image generation/sharing set of microservices.

User's will enter a URL such as `koinonia.com/image/{md5-hash}` which will load a web page displaying the image associated with the specified hash.

If the image hasn't been processed yet then the URL will display a message to indicate the image isn't ready for viewing yet.

## Quick start

To run everything:

```bash
docker-compose up
curl $(boot2docker ip):8080
```

To stop everything:

```bash
docker-compose stop
```

## front-end

Clojure front-end application, which displays specified shared image and allows user to create a new sharable image URL.

![Koinonia front-end design](http://www.websequencediagrams.com/cgi-bin/cdraw?lz=dGl0bGUgS29pbm9uaWEgZnJvbnQtZW5kCgphbHQgQ3JlYXRlIGEgbmV3IHNoYXJhYmxlIGltYWdlIFVSTAogIENsaWVudC0-ADoIOiBIVFRQIFBPU1RcbihVUkwgKyBDU1Mgc2VsZWN0b3IpCiAAZQktPkFXUyBTUVM6IGZpcmUgJiBmb3JnZXQgbWVzc2FnZQAaEUR5bmFtb0RCOiBzdG9yZSBoYXNoAEMNAIEIBjogVVJMIHRvAIEtBWVcbihNRDUAJwUgb2YAFgUAgQMQZWxzZSBWaQCBXQdlZACBPh5HRVRcbihrAIIsBy5jb20vAIINBS97TUQ1LWhhc2h9AIFYDlJlZGlzOiBsb29rdXAAgQMGa2V5CiAgYWx0IGtleSBleGlzdHMKICAgIAAnBQCCQwwAgmgFABYFAIFVElBhZ2Ugd2l0aACDDAcoMjAwIFN0YXR1cyBDb2RlKQogIACBVwVrZXkgZG9lc24ndABnBgBWFkVycm9yIChubwCBEQVmb3VuZCkAbA8AgnkOAIFICwCBOQVhbHQAgmMGAIFHCyAgAIMvDACEHgxyZWNvcmQAHgcAhAYPMwCCYQx7UzMgb2JqZWN0IHdhcwCDdwZkIHVzaW5nIACCawkAZgdhbHQgACUKAHsNAIEEBlMzAIJOESAoAFgJAIFqBgCCYQ4AgzkHAIRuBgCCYwcAgnEFAIRPCWFzIGtleQAoFACCfywgIACDKAcAgWUKAIMjEgCBMRYAgzAKAIIhBwCDMgsAhBwgIkkAh0sFbm90IHJlYWR5IgCGeAggKDIwNACBEBVuAIMwBgCGMwVubwCICgdvZiB0aGlzAIZkBnByZXZpb3VzbHkgZ2VuZXJhdGUAg2IIAIN3GG5vAIQLBwCEdAYAhAcRAIVkEmUAhSsFIk4AeggAhS0FIiAoNACBIxQAgS8GZW5kCgCJWgUjIEV4YW1wbGU6CiMgYjJhOGMxMTk2NDc4Mzg2ODIwNjA0ZDliZGFhNjE2YmYgaXMAg2MKb2Y6CiMgaHR0cDovL3d3dy5pbnRlZ3JhbGlzdC5jby51ay8gQU5EIC5sYW5ndWFnZS1ydWJ5Om50aC1vZi10eXBlKDEp&s=rose)

## back-end

Ruby back-end that is decoupled from the front-end by a message queue (via AWS SQS). Utilises [BBC Wraith](https://github.com/BBC-News/wraith) (a responsive screenshot comparison tool) to capture the image and to store it within AWS S3.

![Koinonia back-end design](http://www.websequencediagrams.com/cgi-bin/cdraw?lz=dGl0bGUgS29pbm9uaWEgYmFjay1lbmQKCgACES0-QVdTIFNRUzogcG9sbCBmb3IgbWVzc2FnZXMKABQHLT4AORE6AB0IIGNvbnRlbnQARhQAIxNCQkMgV3JhaXRoXG5SdWJ5IEFwcGxpY2F0aW9uAIEEGTM6IHN0b3JlIGdlbmVyYXRlZCBpbWFnZQ&s=rose)

### TODO:

- Give TTL for S3 objects
  - S3 deletion event should trigger deletion of associated DynamoDB record
