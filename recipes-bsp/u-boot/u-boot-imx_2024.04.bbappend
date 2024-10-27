FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://boot.cmd"

UBOOT_ENV = "boot"
UBOOT_ENV_SUFFIX = "scr"
