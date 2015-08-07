DESCRIPTION = "Package groups for Halon applications"
LICENSE = "HP"
PR = "r1"
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = ' \
            packagegroup-halon \
            packagegroup-halon-base \
            packagegroup-halon-min \
            packagegroup-halon-min-debug \
            packagegroup-halon-core \
            '

#
# packages which content depend on MACHINE_FEATURES need to be MACHINE_ARCH
#
PACKAGE_ARCH = "${MACHINE_ARCH}"

RDEPENDS_packagegroup-halon-base = "\
    os-release \
    i2c-tools \
    mtd-utils \
    gptfdisk \
    packagegroup-base-serial \
    lttng-tools lttng-modules lttng-ust babeltrace \
    kexec kdump \
    rsyslog \
    iproute2 \
    vim \
    tzdata-posix \
    valgrind \
    valgrind-memcheck \
    valgrind-helgrind \
    sudo \
    pwauth \
    halon-init \
    virtual/switchd \
    ${@bb.utils.contains('MACHINE_FEATURES', 'halonsim', 'ovs-sim-plugin', '',d)} \
    halon-ovsdb \
    virtual/halon-config \
    cfgd fand ledd pmd powerd sysd tempd \
    intfd lacpd lldpd vland arpmgrd \
    script-utils \
    cli restd webui \
    l3portd quagga \
    cronie \
    inetutils-ping inetutils-ping6 inetutils-hostname inetutils-ifconfig \
    inetutils-tftp inetutils-traceroute inetutils-ftp inetutils-telnet \
    xinetd \
    aaa-utils \
    pam-plugin-radius-auth \
"

RDEPENDS_packagegroup-halon-base_append_arm = "\
    u-boot-fw-utils \
    t32server\
    "

RDEPENDS_packagegroup-halon-min = "\
    python \
    python-pyroute2 \
    yaml-cpp \
    libevent \
    util-linux-uuidgen \
    iptables \
    "

RDEPENDS_packagegroup-halon-min-debug = "\
    file strace ldd tcpdump gdb gdbserver eglibc-thread-db \
    iperf ethtool tcf-agent nfs-utils-client \
    "

RDEPENDS_packagegroup-halon-core = "\
    "
