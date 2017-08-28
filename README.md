A simple server for receiving location updates and providing the latest location information or redirecting to Google
maps. Target platform is AWS EC2 (but the code here is cloud-agnostic). Intended usage is to track, record and provide
location information during our sabbatical leave.

TODO:
- Don't store passwords in clear text (irrelevant with OAuth 2).
- Use Google OAuth 2 (get token on the device, send with each request, validate on the server and fetch basic user info,
  base authorization on rules matching user name, email or whatever).
- Use HTTPS. Currently, there is no domain and Let's Encrypt do not support SSL for IPs, so we just use HTTP. This means
  passwords are sent around in clear text, which is a Very Bad Thing, but for now I don't care in for this application.