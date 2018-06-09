FROM lasseufpa/nfd

RUN mkdir -p /ndn
RUN ndnsec-keygen /ndn && ndnsec-sign-req /ndn | ndnsec-install-cert -