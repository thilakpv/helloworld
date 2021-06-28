# 1. Base image from KP repo
FROM docker-baseimages.devopsrepo.kp.org/websphere-liberty:20.0.0.9-full-java8-ibmjava-kp

# 2. Copy war file artifact into dropins inside container
COPY --chown=1001:0 target/*.war /config/dropins/

# 3. Default setting for the verbose option
ARG SSL=true
ARG MP_MONITORING=true
ARG VERBOSE=false

# 4. Switching to non-root user
USER 1001

#Run command to check the seccomp
RUN grep Seccomp /proc/$$/status

# 5. Required for liberty
RUN configure.sh

# 6. Add app label
LABEL app='aks-uc1'
