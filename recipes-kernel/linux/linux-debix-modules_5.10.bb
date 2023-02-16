SUMMARY = "Extra kernel modules"
DESCRIPTION = "Extra kernel modules for DEBIX Model A"
LICENSE = "CLOSED"

SRC_URI = "git://github.com/debix-tech/linux;protocol=https;branch=debix"
SRCREV = "f924d76e63c153f58206425d31f88c5771caeb80"

S = "${WORKDIR}"

do_unpack:append() {
    bb.build.exec_func('shell_do_unpack_extra', d)
}

shell_do_unpack_extra() {
    tar xf ${WORKDIR}/git/.extra.tar -C ${WORKDIR}
}

inherit module-base

do_compile[noexec] = "1"

do_install() {
    cd ${S}/extra

    install -d ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}
    tar --no-same-owner --exclude='./patches' --exclude='./.pc' -cpf - . \
        | tar --no-same-owner -xpf - -C ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}
}

FILES_${PN} = "/lib/modules"
