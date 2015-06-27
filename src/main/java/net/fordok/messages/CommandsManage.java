package net.fordok.messages;

/**
 * User: Fordok
 * Date: 1/4/2015
 * Time: 9:15 PM
 */
public class CommandsManage {
    public static final class Start extends CommandsManage {};
    public static final class Stop extends CommandsManage{};
    public static final class Suspend extends CommandsManage{};
    public static final class Resume extends CommandsManage{};
}
