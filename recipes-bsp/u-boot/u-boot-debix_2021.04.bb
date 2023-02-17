# Copyright (C) 2013-2016 Freescale Semiconductor
# Copyright 2018 (C) O.S. Systems Software LTDA.
# Copyright 2017-2021 NXP
# Copyright 2023 Yusuke Mitsuki <mickey.happygolucky@gmail.com>

require recipes-bsp/u-boot/u-boot.inc

DESCRIPTION = "i.MX U-Boot suppporting DEBIX Model A board."

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

PROVIDES = "virtual/bootloader u-boot"

UBOOT_SRC ?= "git://github.com/debix-tech/uboot.git;protocol=https"
SRCBRANCH = "lf_v2021.04"
SRC_URI = "${UBOOT_SRC};branch=${SRCBRANCH}"
SRCREV = "1a87b972fac74699482e2dce2023b66358d8c4f5"

LOCALVERSION = "-${SRCBRANCH}"

DEPENDS += "flex-native bison-native bc-native dtc-native"

S = "${WORKDIR}/git"
B = "${WORKDIR}/build"

inherit fsl-u-boot-localversion

BOOT_TOOLS = "imx-boot-tools"


do_deploy:append:debix-a() {
    # Deploy u-boot-nodtb.bin and fsl-imx8m*-XX.dtb for mkimage to generate boot binary
    if [ -n "${UBOOT_CONFIG}" ]
    then
        for config in ${UBOOT_MACHINE}; do
            i=$(expr $i + 1);
            for type in ${UBOOT_CONFIG}; do
                j=$(expr $j + 1);
                if [ $j -eq $i ]
                then
                    install -d ${DEPLOYDIR}/${BOOT_TOOLS}
                    install -m 0777 ${B}/${config}/arch/arm/dts/${UBOOT_DTB_NAME}  ${DEPLOYDIR}/${BOOT_TOOLS}
                    install -m 0777 ${B}/${config}/u-boot-nodtb.bin  ${DEPLOYDIR}/${BOOT_TOOLS}/u-boot-nodtb.bin-${MACHINE}-${type}
                fi
            done
            unset  j
        done
        unset  i
    fi
}

UBOOT_TAGGED_BINARY ?= "u-boot-tagged.${UBOOT_SUFFIX}"

deploy_tag() {
    # Append a tag to the bootloader image used in the SD card image
    cp ${UBOOT_BINARY} ${UBOOT_TAGGED_BINARY}
    ln -sf ${UBOOT_TAGGED_BINARY} ${UBOOT_BINARY}
    stat -L -cUUUBURNXXOEUZX7+A-XY5601QQWWZ%sEND ${UBOOT_BINARY} >> ${UBOOT_BINARY}
}

do_deploy:append:debix-a() {
    deploy_tag
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "debix-a"

UBOOT_NAME:debix-a = "u-boot-${MACHINE}.bin-${UBOOT_CONFIG}"
